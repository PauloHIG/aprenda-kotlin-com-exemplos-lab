fun main() {
    val bemVindo = Curso("Bem Vindo a plataforma da DIO","Como aproveitar nossa plataforma","BASICO",1)
    val formaKotlin = Formacao("Kotlin backend developer","aprenda uma stack de kotlin","INTERMEDIARIO")
    val dockerCont = Curso("Fundamentos de Docker","Criação de micro serviços","BASICO",3)
    val javaFund = Curso("Java básico","Configure o ambiente e faça seus primeiros códigos","BASICO",4)
    val aprendaGit = Curso("Introdução ao Git e GitHub",
                           "Conheça o básico da ferramenta de versionamento mais popular",
                           "BASICO",
                           2)
    val desafioKotlin1 = Desafio("Primeiro Código Kotlin","Printe Olá Mundo na tela","BASICO")
    val desafioKotlin2 = Desafio("Média",
                                 "Você receberá três inputs de aluno, calcule a media e retorne se ele foi aprovado ou reprovado",
                                 "BASICO")
    
    formaKotlin.todosOsConteudos.add(bemVindo)
    formaKotlin.todosOsConteudos.add(dockerCont)
    formaKotlin.todosOsConteudos.add(javaFund)
    formaKotlin.todosOsConteudos.add(desafioKotlin1)
    formaKotlin.todosOsConteudos.add(desafioKotlin2)
    
    val paulo = Dev("Paulo")
    val quem = Dev("O Doutor")
    quem.bio = "Viajo no tempo pois o tempo não é linear"
    quem seMatriculaEm dockerCont
    quem seMatriculaEm aprendaGit
    quem concluiu aprendaGit
    println(quem)
    
    paulo seMatriculaEmFormacao formaKotlin
    paulo concluiu javaFund
    paulo concluiu desafioKotlin1
    paulo concluiu aprendaGit //ele não está matriculado nesse curso
    println(paulo)
	paulo.mudarNome("pedro")
    println(paulo)
}