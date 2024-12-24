package com.example.cursinhoisaac

// Classe para representar os dados dos gráficos
data class GraficoData(
    val titulo: String,
    val texto: String,
    val arquivoJson: String // Adicionamos o nome do arquivo JSON
)

// Lista com os dados dos gráficos
val graficos = listOf(
    GraficoData(
        titulo = "A Criação",
        texto = """
            A Criação
            
            Texto Bíblico: 
            Gênesis 1
            
            No princípio Deus criou os céus e a Terra. Você se lembra do que Deus criou em cada dia da semana?
            Arraste o ponto na tela para ver!
        """.trimIndent(),
        arquivoJson = "ACriacao.json"
    )
)
