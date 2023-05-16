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
