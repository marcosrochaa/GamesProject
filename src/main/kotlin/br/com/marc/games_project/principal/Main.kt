package br.com.marc.games_project.principal

import br.com.marc.games_project.modelo.Game
import br.com.marc.games_project.modelo.InfoGame
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val leitura = Scanner(System.`in`)
    println("Digite o código do jogo")
    val busca = leitura.nextLine()

    val endereco = "https://www.cheapshark.com/api/1.0/games?id=$busca"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder().uri(URI.create(endereco)).build()
    val response = client.send(request, BodyHandlers.ofString())

    val json = response.body()
    println(json)

    val gson = Gson()
    val myInfoGame = gson.fromJson(json, InfoGame::class.java)

//    try {
//        val myInfoGame = gson.fromJson(json, br.com.marc.games_project.modelo.InfoGame::class.java)
//        val myGame = br.com.marc.games_project.modelo.Game(
//            myInfoGame.info.title,
//            myInfoGame.info.thumb
//        )
//
//        println(myGame)
//
//    } catch (ex: JsonSyntaxException) {
//        println("Retorno vazio. Tente outro id.")
//    } catch (ex: NullPointerException) {
//        println("Jogo inexistente. Tente outro id.")
//    }
    var myGame: Game? = null

    val resultado = runCatching {
         myGame = Game(
            myInfoGame.info.title,
            myInfoGame.info.thumb
        )

    }
    resultado.onFailure {
        println("Jogo Inexistentw, Tente outro ID")

    }
    resultado.onSuccess {
        println("Deseja inserir uma descrição personalizada? S/N")
        val opcao = leitura.nextLine()
        if (opcao.equals("s", true)) {
            println("Insira a descrição personalizada para o jogo:")
            val descricaoPersonalizada = leitura.nextLine();
            myGame?.descricao = descricaoPersonalizada
        } else {
            myGame?.descricao = myGame?.Titulo
        }

        println(myGame)
    }
}



