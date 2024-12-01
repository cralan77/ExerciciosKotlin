val students : MutableList<Student> = mutableListOf()
val courses : MutableList<Course> = mutableListOf()
val formations: MutableList<Formation> = mutableListOf()

fun listCourses(){
    for (course in courses){
        println("[${course.id}] - ${course.name}")
        println(course)
    }
}

fun registerStudent(){
    print("Digite o ID do aluno: ")
    val id = readln().toInt()
    print("Digite o nome do aluno: ")
    val name = readln()

    val student = Student(id, name)
    students.add(student)
    println("Cadastro efetuado com sucesso.")
}

fun registerCourse(){
    print("Digite o ID do curso: ")
    val id = readln().toInt()
    print("Digite o nome do curso: ")
    val name = readln()
    print("Digite a duração do curso (apenas numeros em horas): ")
    val duration = readln().toInt()
    print("Digite o nivel do curso (BASICO, INTERMEDIARIO, AVANCADO): ")
    val level = Level.valueOf(readln().uppercase())

    val course = Course(id, name, duration, level)
    courses.add(course)
    println("Cadastro efetuado com sucesso.")
}

fun registerFormation(){

    if(courses.size>0 ) {
        print("Digite o ID da formação: ")
        val id = readln().toInt()
        print("Digite o nome da formação: ")
        val name = readln()
        // duration declared 0, duration sum of courses in formation
        val duration = 0
        print("Digite o nivel da formação (BASICO, INTERMEDIARIO, AVANCADO): ")
        val level = Level.valueOf(readln().uppercase())

        val formation = Formation(id, name, duration, level)
        formations.add(formation)
        println("Cadastro efetuado com sucesso.")

        println("Agora será necessário criar modulos")
        registerModule(formation)

    }else{
        println("É necessário cadastrar cursos antes de criar uma formação")
    }

}

fun registerModule(formation: Formation){
    println("Quantos modulos deseja cadastrar: ")
    val quantityModule = readln().toInt()

    for (i in 1..quantityModule){
        println("Digite o nome do $i modulo")
        val nameModule = readln()

        val module = Module(nameModule)

        var checkAddItems  = true

        while(checkAddItems) {
            listCourses()
            println("Agora digite o ID do curso")
            val idCourse = readln().toInt()
            for (course in courses){

                if(course.id == idCourse){
                    module.addCourse(course)
                    println("Cadastro efetuado com sucesso.")

                }

            }

            println("Deseja adicionar novo curso ao modulo ? \n [1]-Sim \n [2]-Não")
            val addCourse = readln().toInt()
            if(addCourse==2){
                checkAddItems=false
                formation.addModule(module)
            }

        }

        




    }
}


fun registerStudentCourse(student: Student){

    listCourses()
    print("Digite o ID do curso que deseja matricular o aluno: ")
    val idCourse = readln().toInt()
    for (course in courses){

        if(course.id == idCourse){
            student.registerCourses(course)
            println("Cadastro efetuado com sucesso.")
        }

    }

}

fun listFormations(){
    for (formation in formations){
        println("[${formation.id}] - ${formation.name}")
        println(formation)
    }

}
fun registerStudentFormation(student: Student){


    listFormations()

    print("Digite o ID da formação que deseja matricular o aluno: ")
    val idFormation = readln().toInt()
    for (formation in formations){

        if(formation.id == idFormation){
            student.registerFormations(formation)
            println("Cadastro efetuado com sucesso.")
        }

    }

}

fun listStudents(){
    for (student in students){
        println(student.toString())
    }
}
fun registerStudentStudy( option :Int){

    listStudents()

    print("Digite o ID do aluno que deseja matricular: ")
    val idStudent = readln().toInt()

    var studentOBJ  = Student(null, null)
    for (student in students){
        if (student.id == idStudent){
            studentOBJ = student
        }

    }
    if (studentOBJ.id != null){
        when(option){
            4 -> registerStudentCourse(studentOBJ)
            5 -> registerStudentFormation(studentOBJ)

        }
    }
}

fun exampleInfos(){

    //add Students


    val listStudent : List<Student> =
        listOf(
                Student(1, "Ana Silva"),
                Student(2, "Pedro Santos"),
                Student(3, "Maria Oliveira"),
                Student(4, "João Almeida"),
                Student(5, "Laura Fernandes"))
    for (student in listStudent) {
        students.add(student)
    }

    val listCourse : List<Course> =
        listOf(
                Course(1, "Python", 3, Level.valueOf("BASICO")),
                Course(2, "Java", 4, Level.valueOf("AVANCADO")),
                Course(3, "JavaScript", 2, Level.valueOf("INTERMEDIARIO")),
                Course(4, "C#", 5, Level.valueOf("AVANCADO")),
                Course(5, "R", 3, Level.valueOf("INTERMEDIARIO"))
        )
    for (course in listCourse){
        courses.add(course)
    }

    val formation = Formation(1, "Backend", 0, Level.AVANCADO)
    formations.add(formation)

    val moduleOne = Module("Inicial")
    val moduleTwo = Module("Conhecendo um pouco mais")
    var count = 0
    for (course in courses){
        if(count <3){
            moduleOne.addCourse(course)
        }else{
            moduleTwo.addCourse(course)
        }

        count++
    }

    formation.addModule(moduleOne)
    formation.addModule(moduleTwo)

    count=0

    for (student in students){
        if(count %2 ==0){
            var test= 0
            for(course in courses){

                if(count - test == 0){
                    student.registerCourses(course)
                }
                test ++
            }

        }else{
            student.registerFormations(formation)

        }
        count++
        println(student)
    }
}

