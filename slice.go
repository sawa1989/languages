package main

import "fmt"

func main() {
	slice1 := []int{1, 2, 3, 4, 5}
	slice2 := make([]int, len(slice1))


	for i, v := range slice1 {  // 각각 복사해줘야함
		slice2[i] = v
	}

	slice1[1] = 100 
	fmt.Println(slice1)
	fmt.Println(slice2)

	slice3 := make([]int, 3, 10) 
	slice4 := make([]int, 10) 

	cnt1 := copy(slice3, slice1) // copy() slice1 -> slice3
	cnt2 := copy(slice4, slice1)

	fmt.Println(cnt1, slice3)
	fmt.Println(cnt2, slice4)

	slice := []int{1,2,3,4,5,6,7}
	idx := 2 
	// for i := idx+1, i< len(slice);i++ {
	// 	slice[i-1] = slice[i]
	// }
	// slice = slice[:len(slice)-1] // 마지막 자르기

	slice = append(slice[:idx], slice[idx+1:]...) 
	fmt.Println(slice)

	slice7 := []int{1, 2, 3, 4, 5, 6}
	slice7 = append(slice7, 0)
	// for i := len(slice7) - 2; i >= idx; i-- {
	// 	slice7[i+1] = slice7[i]
	// }
	copy(slice7[idx+1:], slice7[idx:])
	slice7[idx] = 100
	fmt.Println(slice7)

}