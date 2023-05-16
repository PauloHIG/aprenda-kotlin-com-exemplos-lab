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