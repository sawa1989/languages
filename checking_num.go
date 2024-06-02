package main

import (
	"bufio"
	"fmt"
	"math/rand"
	"os"
	"time"
)

var stdin = bufio.NewReader(os.Stdin)

func InputIntValue() (int, error) {
	var n int
	_, err := fmt.Scanln(&n)
	if err != nil {
		stdin.ReadString('\n')
	}
	return n, err
}

func main() {
	rand.Seed(time.Now().UnixNano())

	r := rand.Intn(100) 
	cnt := 1
	for {
		fmt.Printf("enter number:")
		n, err := InputIntValue()
		if err != nil {
			fmt.Println("enter number only")
		} else {
			if n > r { 
				fmt.Println("larger than")
			} else if n < r {
				fmt.Println("smaller than")
			} else {
				fmt.Println("Answer", cnt)
				break
			}
			cnt++
		}
	}
}