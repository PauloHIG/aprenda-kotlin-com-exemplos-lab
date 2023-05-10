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
class Formacao(val nome:String, val descr:String,val nivel:String){
    val todosOsConteudos=mutableSetOf<Conteudo>()
    
    override fun toString():String{
        var retorno:String ="$nome\n$descr\nNível $nivel"
        if(todosOsConteudos.isNotEmpty()){
            retorno+="\nVeja todos os conteudos dessa formação:"
            for(conteudo in todosOsConteudos){
                retorno +="\n"+ conteudo.nome
            }
        }
        return retorno
    }
    
}
abstract class Conteudo(val nome:String, val descr:String,val nivel:String){
    abstract val alunosMatriculados:MutableList<Dev> 
    override fun toString():String{
        return "$nome\n$descr\nNível $nivel"
    }
    abstract fun retornarXp():Int
}
class Curso(nome:String, descr:String, nivel:String,val horas:Int):Conteudo(nome,descr,nivel){
    override val alunosMatriculados = mutableListOf<Dev>()
    
    fun mostrarDevsMatriculados(){
        println("Lista de alunos matriculados em $nome")
        for(aluno in alunosMatriculados){
            println("Nome:"+ aluno.exibirNome())
        }
    }
    override fun retornarXp():Int{
        return 10*horas
    }
}
class Desafio(nome:String, descr:String, nivel:String):Conteudo(nome,descr,nivel){
    override val alunosMatriculados = mutableListOf<Dev>()
    
    fun mostrarDevsMatriculados(){
        println("Lista de alunos que aceitaram o desafio $nome")
        for(aluno in alunosMatriculados){
            println("    "+ aluno.exibirNome())
        }
    }
    override fun retornarXp():Int{
        return 50
    }
}

class Dev(private var nome:String){
    var bio = "Olá, sou um futuro desenvolvedor"
    val conteudosConcluidos = mutableListOf<Conteudo>()
    fun mudarNome(novoNome:String){
        nome = novoNome
    }
    fun exibirNome():String{return nome}
    infix fun seMatriculaEm(conteudo:Conteudo){
        conteudo.alunosMatriculados.add(this)
        println("$nome foi matriculado em "+conteudo.nome+" com sucesso")
    }
    infix fun concluiu(conteudo:Conteudo){
        if(conteudo.alunosMatriculados.contains(this)){
            conteudosConcluidos.add(conteudo)
        }
        else{println("Você precisa se matricular primeiro")}
    }
    
    infix fun seMatriculaEmFormacao(formacao:Formacao){
        for(conteudo in formacao.todosOsConteudos){
            this seMatriculaEm conteudo
        }
    }
    fun calcularXp():Int{
        var soma:Int = 0
        for(conteudo in conteudosConcluidos){
            soma+= conteudo.retornarXp()
        }
        return soma
    }
    
    override fun toString():String{
        return "Perfil do Desenvolvedor\nNome:$nome\nBiografia: $bio\nExperiência:"+ calcularXp()
    }
    
}