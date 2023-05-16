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