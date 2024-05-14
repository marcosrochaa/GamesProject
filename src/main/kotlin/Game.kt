class Game (
    val Titulo : String,
    val Capa : String )
{
    val Descricao = String
    override fun toString(): String {
        return "My Game: " +
                "Titulo='$Titulo \n" +
                "Capa='$Capa \n" +
                "Descricao=$Descricao \n"
    }
}