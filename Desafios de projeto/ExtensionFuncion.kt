/*
Descrição
As Extension Functions, ou Funções de Extensão, são recursos poderosos disponíveis em linguagens de programação que permitem adicionar métodos a classes existentes sem a necessidade de modificar o código-fonte original dessas classes. Isso facilita a criação de novas funcionalidades ou comportamentos para tipos de dados já existentes, mesmo quando você não tem acesso ao código fonte original desses tipos.

Neste desafio, com foco em um sistema de gerenciamento de livros para uma biblioteca digital, você deve implementar uma solução que permita gerar um "slug" único para representar os dados de um livro. Um "slug" é uma versão simplificada e amigável para URLs de um texto, com espaços substituídos por traços (-) e caracteres especiais removidos. A solução requer que você crie uma função de extensão generateSlug() para a classe String que fará essa transformação.

Funcionalidade a ser implementada:

generateSlug(): Crie uma função de extensão chamada generateSlug() para a classe String. A função deve gerar um "slug" para a string fornecida, removendo espaços e caracteres especiais, substituindo-os por traços.

Entrada
A entrada consistirá em duas strings: o título e o autor de um livro.

Saída
Imprima o "slug" gerado para o livro, no seguinte padrão:
Slug gerado para o livro:
nome-livro-separado-por-ifens_nome-autor-separado-por-ifens

Exemplos
A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.

Entrada	Saída
Senhor dos Aneis
J. R. R Tolkien
Slug gerado para o livro:
senhor-dos-aneis_j-r-r-tolkien
O Enigma do Parque
Jody Shields
Slug gerado para o livro:
o-enigma-do-parque_jody-shields
O Chamado de Cthulhu
H. P. Lovecraft
Slug gerado para o livro:
o-chamado-de-cthulhu_h-p-lovecraft
Nota:
O uso de extension functions tem seus pontos positivos, como a extensibilidade e organização do código, mas também apresenta desafios, como a possível confusão e a separação da lógica. A solução eficiente depende da linguagem de programação escolhida e das práticas de programação adotadas.

Saiba mais sobre Extension Functions em Kotlin:
https://kotlinlang.org/docs/extensions.html#extension-functions
*/

fun main() {
    val titulo = readLine() ?: ""
    val autor = readLine() ?: ""

    val slugTitulo = titulo.generateSlug()
    val slugAutor = autor.generateSlug()

    println("Slug gerado para o livro:")
    println("${slugTitulo}_${slugAutor}")
}

fun String.generateSlug(): String {
    //inicia variável vazia
    var slug =""
    //Lista de caracteres liberados
    val caracteresLiberados =
        listOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t","u", "v", "w", "x", "y", "z",
            " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0")

    // Varre String que invocou metodo para eliminar caracteres não permitidos e padroniza minusculo
    for(i in this){
        if (i.lowercase() in caracteresLiberados){
            slug +=i.lowercase()
        }
    }

    //Retorna Slug substituindo espaço por hifen
    return slug.replace(" ", "-")
}