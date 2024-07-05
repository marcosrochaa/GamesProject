package br.com.marc.games_project.principal

import br.com.marc.games_project.model.Game
import br.com.marc.games_project.model.UserGamer
import br.com.marc.games_project.services.ConsumoApi
import turnIntoAge
import java.util.Scanner

// ALUGUEL DE GAMES
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val leitura = Scanner(System.`in`)

    val gamer = UserGamer.criarGamer(leitura)
    println("Cadastro concluido")
    println(gamer)
    println("Idade do Gamer:" + gamer.dataNascimento?.turnIntoAge())

    do {
        println("Digite o código do jogo")
        val busca = leitura.nextLine()

        val searchAPI = ConsumoApi()
        val myInfoGame = runCatching { searchAPI.buscaJogo(busca) }

        myInfoGame.onFailure {
            println("Return error")
        }

        var myGame: Game? = null

        val resultado = runCatching {
            myGame = Game(
                myInfoGame.getOrNull()?.info?.title.orEmpty(),
                myInfoGame.getOrNull()?.info?.thumb.orEmpty()
            )

        }
        resultado.onFailure { it: Throwable ->

            println("Jogo Inexistente, Tente outro ID")
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
          gamer.jogosBuscado.add(myGame)
        }

        println("deseja buscar um novo jogo ? S/N")
        val resposta = leitura.nextLine()


    } while(resposta.equals("S", true))

    println("Jogos buscados")
    println(gamer.jogosBuscado)
   println ("Busca Finalizada com sucesso")

}



