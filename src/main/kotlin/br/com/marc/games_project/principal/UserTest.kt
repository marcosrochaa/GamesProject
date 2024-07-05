import br.com.marc.games_project.model.UserGamer

fun main () {

    val gamer1 = UserGamer(" Gamer1", "marcos@gmail.com")

    val gamer2 = UserGamer("Gamer2", "marc@gmail.com",
        "20/05/2000",
        "marc",
        "gamer123")

    println(gamer2)

    gamer1.let {
        it.dataNascimento = "16/12/1998"
        it.user = "Lana"
    }.also {
        println(gamer1.idInterno)
    }
        println(gamer1)
        gamer1.user= "aaaaaaaaaaaaaaaaaaaaaaaa"
    println(gamer1)

}