package main

import (
	"bufio"
	"fmt"
	"os"
)


func main() {
	stdin := bufio.NewReader(os.Stdin)
	for {
		fmt.Println("Please enter your keyword(s)")
		var number int
		_, err := fmt.Scanln(&number)
		if err != nil {
			fmt.Println("Please enter Number")
			stdin.ReadString('\n')
			continue
		}
		fmt.Printf("number is %d \n", number)
		if number%2 ==0 {
			break
		}
	}
	fmt.Println("for is ended")
}