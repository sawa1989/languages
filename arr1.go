package main
import "fmt"

func main(){
	var t [5]float64 = [5]float64{24.0, 25.9, 27.8, 20.2, 1.1}
	// var nums [5]int
	// days := [3]string{"m", "t", "w"}
	// var s = [5]int{1:10, 3:30}
	// x := [...]int{10, 20,30}

	for i :=0; i<5; i++ {
		fmt.Println(t[i])
	}

	for i, v := range t { // index, 변수값
		fmt.Println(i, v)
	}
	for _, v := range t { // index무효화가능, 변수값
		fmt.Println(v)
	}	

	// 행 열
	a := [2][5]int {
		{1,2,3,4,5},
		{6,7,8,9,10},
	} // }가  같은줄에 있으면 , 없어도됨

	for _, arr := range a {
		for _, v := range arr {
			fmt.Print(v, " ")
		}
	}
}