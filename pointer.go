package main

import "fmt"

type Data struct {
	value int
	data  [200]int
}

func ChangeData(arg *Data) { 
	arg.value = 999 
	arg.data[100] = 999
}


func NewUser(name string, age int) *User {
	var u = User{name, age}
	return &u  // 탈출 검사를 통해서, 외부로 공개되는 것 확인 - 힙 메모리에 할당하게됨.
}

func main() {
	var data Data

	ChangeData(&data)                      
	fmt.Printf("value = %d\n", data.value) 
	fmt.Printf("data[100] = %d\n", data.data[100])

	var data1 Data
	var p *Data = &data1

	var p *Data = &Data{} // 구조체 생성 초기화

	// 인스턴스 : 메모리에 할당된 데이터의 실체
	p1 := &Data{}
	var p2 = new(Data)

	userPointer := NewUser("AAA", 23)
	fmt.Println(userPointer)
}