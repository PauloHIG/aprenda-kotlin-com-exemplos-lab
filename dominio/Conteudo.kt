abstract class Conteudo(val nome:String, val descr:String,val nivel:String){
    abstract val alunosMatriculados:MutableList<Dev> 
    override fun toString():String{
        return "$nome\n$descr\nNível $nivel"
    }
    abstract fun retornarXp():Int
}