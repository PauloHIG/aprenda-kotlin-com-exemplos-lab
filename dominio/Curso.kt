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