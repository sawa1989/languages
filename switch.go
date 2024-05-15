package main

import "fmt" 

func getMyAge() int{
	return 33
}

func main() {
	switch age := getMyAge(); age { // switch문에서도 초기문을 넣을 수 있음. 
	case 10:
		fmt.Println("Teenage")
	case 33:
		fmt.Println("3 two")
		fallthrough // 다음 case문까지 실행
	default:
		fmt.Println("My age is", age)
	}
	// fmt.Println("age is", age)
}