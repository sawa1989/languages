package main 

import "fmt"

type House struct {
	Address string
	Size int
	Price float64
	Type string
}

func main() {
	var house House
	house.Address = "서울 강남"
	house.Size = 28
	house.Price = 9.8
	house.Type = "아파트"

	var house1 House = House{Size:28, Type: "Aprt"}

	fmt.Println("주소", house.Address)
	fmt.Println("Size : ", house1.Size)
}