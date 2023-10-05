// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Usuario(val nome: String, val matricula: String, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    private val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
        } else {
            println("O usuário ${usuario.nome} já está matriculado.")
        }
    }

    fun listarInscritos() {
        inscritos.forEach { println(it.nome) }
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Matemática Básica", 45)
    val conteudo2 = ConteudoEducacional("História do Brasil", 50)
    val formacao = Formacao("Ensino Fundamental", listOf(conteudo1, conteudo2))

    val usuario1 = Usuario("João", "12345", Nivel.BASICO)
    val usuario2 = Usuario("Maria", "67890", Nivel.INTERMEDIARIO)

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.matricular(usuario1) // Tentativa de matricular novamente

    println("Usuários matriculados:")
    formacao.listarInscritos()
}

