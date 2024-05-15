package main

import (
	"bufio"  // io 담당 패키지
	"fmt"
	"os" // 표준 입출력 등을 가지고 있는 패키지 
)

func main() {
	stdin := bufio.NewReader(os.Stdin) // 선언대입문

	var a int
	var b int

	n, err := fmt.Scanln(&a, &b)

	if err != nil { 
		fmt.Println(err)
		stdin.ReadString('\n') // 표준 입출력 스트림 지우는 것
	}else {
		fmt.Println(n, a, b)
	}

	n,err = fmt.Scanln(&a, &b)
	if err != nil {
		fmt.Println(err)
	}else{
		fmt.Println(n, a, b)
	}

}