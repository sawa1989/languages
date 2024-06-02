package main

import "fmt"

type User struct {
	Name string
	ID string
	Age int
	Level int
}

type VIPuser struct {
	User 
	Price int
	Level int
}

func main(){
	user := User{"Kyoin", "Kyo", 27, 10}
	vip := VIPuser{
		User{"In", "INN", 26, 12},
		200,
		3, // 쉼표 필수
	}
	fmt.Printf("유저: %s ID: %s 나이 %d\n", user.Name, user.ID, user.Age)
	fmt.Printf("VIP 유저: %s ID: %s 나이 %d VIP 레벨: %d 유저 레벨:%d\n",
		vip.Name,
		vip.ID,
		vip.Age,
		vip.Level,      
		vip.User.Level, 
	)

	
}