package main

import (
 "context"
 "flag"
 "fmt"
 "os"

 "k8s.io/client-go/kubernetes"
 "k8s.io/client-go/rest"
 "k8s.io/client-go/tools/clientcmd"
 metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
)

func main() {
 kubeconfig := flag.String("kubeconfig", "", "path to the kubeconfig file (default: use in-cluster configuration)")
 namespace := flag.String("namespace", "default", "the namespace of the pods to delete")
 podName := flag.String("pod", "", "the name of the pod to delete (required)")

 flag.Parse()

 fmt.Printf("kubeconfig: %s\n", *kubeconfig)
 fmt.Printf("namespace: %s\n", *namespace)
 fmt.Printf("pod: %s\n", *podName)

 if *podName == "" {
  fmt.Fprintln(os.Stderr, "Please provide the pod name.")
  flag.Usage()
  os.Exit(1)
 }

 var config *rest.Config
 var err error

 if *kubeconfig == "" {
  config, err = rest.InClusterConfig()
 } else {
  config, err = clientcmd.BuildConfigFromFlags("", *kubeconfig)
 }

 if err != nil {
  fmt.Fprintf(os.Stderr, "Error creating Kubernetes client configuration: %v\n", err)
  os.Exit(1)
 }

 clientset, err := kubernetes.NewForConfig(config)
 if err != nil {
  fmt.Fprintf(os.Stderr, "Error creating Kubernetes client: %v\n", err)
  os.Exit(1)
 }

 ctx := context.Background()

 err = deletePod(ctx, clientset, *namespace, *podName)
 if err != nil {
  fmt.Fprintf(os.Stderr, "Error deleting pod: %v\n", err)
  os.Exit(1)
 }

 fmt.Printf("Pod %s in namespace %s deleted successfully\n", *podName, *namespace)
}

func deletePod(ctx context.Context, clientset *kubernetes.Clientset, namespace, podName string) error {
 deletePolicy := metav1.DeletePropagationForeground
 return clientset.CoreV1().Pods(namespace).Delete(ctx, podName, metav1.DeleteOptions{
  PropagationPolicy: &deletePolicy,
 })
}
