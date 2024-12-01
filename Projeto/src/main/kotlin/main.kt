//Desafio DIO, abstração DIO


// Massa de teste
// encapsular duração
// tratamento de exceção
// tratar id não encontrado
// editar curso existente
// cadastrar lesson
// listar matriculas de cada aluno

fun main(){

    var execute = true

    while(execute) {
        println("Bem vindo a DIO")
        println("Opções disponíveis ")
        println(
            "[1] Cadastrar aluno\n" +
                    "[2] Cadastrar curso\n" +
                    "[3] Cadastrar formação\n" +
                    "[4] Matricular aluno em curso\n" +
                    "[5] Matricular aluno em formação\n" +
                    "[6] Listar alunos\n" +
                    "[7] Listar cursos\n" +
                    "[8] Listar formações\n"+
                    "[9] Sair\n"+
                    "[0] Carregar dados exemplo"
        )
        print("Digite o numero da opção desejada: ")
        println()
        when (val selectedOption = readln().toInt()) {
            1 -> registerStudent()
            2 -> registerCourse()
            3 -> registerFormation()
            4 -> registerStudentStudy(selectedOption)
            5 -> registerStudentStudy(selectedOption)
            6 -> listStudents()
            7 -> listCourses()
            8 -> listFormations()
            9 -> execute = false
            0 -> exampleInfos()

            else -> print("Opcao Invalida")
        }
        println()
        println()

    }



}