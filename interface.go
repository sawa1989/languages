package main

import "fmt"

type Stringer interface { 
	String() string
}

type Student struct {
	Age int
}

func (s *Student) String() string { 
	return fmt.Sprintf("Student Age:%d", s.Age)
}

func PrintAge(stringer Stringer) { 
	s := stringer.(*Student) // 구체화된 다른 타입으로 변환이 가능함. 
	fmt.Printf("Age: %d\n", s.Age) 
}

func main() {
	student := Student{27} 
	var stringer Stringer 
	stringer = &student
	fmt.Printf("%s\n", stringer.String())

	s := &Student{15}

	PrintAge(s) 
}
