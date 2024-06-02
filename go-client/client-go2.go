package main

import (
 "context"
 "flag"
 "fmt"
 "path/filepath"
 "k8s.io/client-go/kubernetes"
 "k8s.io/client-go/tools/clientcmd"
 "k8s.io/client-go/util/homedir"
 metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
)

func main() {
	var kubeconfig *string
	if home := homedir.HomeDir(); home != "" {
		kubeconfig = flag.String("kubeconfig", filepath.Join(home, ".kube", "config"), "(optional) absolute path to the kubeconfig file")
	} else {
		kubeconfig = flag.String("kubeconfig", "", "absolute path to the kubeconfig file")
	}
	flag.Parse()

	config, err := clientcmd.BuildConfigFromFlags("", *kubeconfig)
	if err != nil {
		panic(err)
	}
	clientset, err := kubernetes.NewForConfig(config)
	if err != nil {
		panic(err)
	}


  pods, _ := clientset.CoreV1().Pods("").List(context.TODO(), metav1.ListOptions{})
  fmt.Printf("There are %d pods in the cluster\n", len(pods.Items))

}

