package br.com.marc.games_project.model

import java.util.Scanner
import kotlin.random.Random

data class UserGamer(
    var nome: String,
    var email: String,

) {
    var dataNascimento: String? = null

    var user: String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()) {
                criaIdInterno()
            }
        }

    init {
        if (nome.isNullOrBlank())
            throw IllegalArgumentException("The name is Blank")
        this.email = emailValidation()
    }

    var idInterno: String? = null
        private set

    val jogosBuscado = mutableListOf<Game?>()

    constructor (
        nome: String,
        email: String,
        dataNascimento: String,
        user: String,
        idInterno: String,
    ) :

            this(nome, email) {
        this.dataNascimento = dataNascimento
        this.user = user
        this.idInterno = idInterno
        criaIdInterno()
    }

    override fun toString(): String {
        return "UserGamer(nome='$nome', " +
                "email='$email', " +
                "dataNascimento=$dataNascimento, " +
                "user=$user, " +
                "idInterno=$idInterno)"
    }


    fun criaIdInterno() {
        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)

        idInterno = "$user#$tag"
    }

    fun emailValidation(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {

            return email
        } else {
            throw IllegalArgumentException("Invalidade email")
        }
    }

    // Código suprimido

    companion object {
        fun criarGamer(leitura: Scanner): UserGamer {
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val nome = leitura.nextLine()

            println("Digite seu e-mail:")
            val email = leitura.nextLine()

            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = leitura.nextLine()

            if (opcao.equals("s", true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val dataNascimento = leitura.nextLine()
                println("Digite seu nome de usuário:")
                val user = leitura.nextLine()

                return UserGamer (nome,email, dataNascimento, user, idInterno = String())
            } else {
                return UserGamer( nome, email)
            }

        }
    }

}
