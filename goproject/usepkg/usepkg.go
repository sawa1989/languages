package main

import (
	"fmt"
	"goproject/usepkg/custompkg"
	"github.com/guptarohit/asciigraph"
)

func main(){
	custompkg.PrintCustom()

	data := []float64{3,4,5,6,7}
	graph := asciigraph.Plot(data)
	fmt.Println(graph)
}