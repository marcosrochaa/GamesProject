package br.com.marc.games_project.model

data class Game (val Titulo : String,
                 val Capa : String ) {
    var descricao : String? = null

    override fun toString(): String {
        return "My br.com.marc.games_project.modelo.Game:\n " +
                "Titulo='$Titulo \n" +
                "Capa='$Capa \n" +
                "Descricao=$descricao \n"
    }
}