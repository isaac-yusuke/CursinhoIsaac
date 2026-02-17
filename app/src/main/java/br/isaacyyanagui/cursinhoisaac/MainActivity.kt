package br.isaacyyanagui.cursinhoisaac

import android.os.Bundle
import android.net.Uri
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.OptIn
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardOptions
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.sp
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import androidx.navigation.NavController
import kotlinx.coroutines.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EscolinhaApp()
        }
    }
}

@Composable
fun EscolinhaApp() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "telaVideo") {
        composable("telaVideo") { TelaVideo(navController) }
        composable("tela1") {
            Tela1(  // Tela inicial
                onIniciarClick = { navController.navigate("tela2") },
                onInstrucoesClick = { navController.navigate("tela3") },
                onReverVideoClick = { navController.navigate("telaVideo") } // Exibe o vídeo ao clicar na imagem3
            )
        }
        composable("tela2") {
            // Obtém os títulos dos gráficos do arquivo Data.kt
            Tela2(  // Lista de graficos
                listaDeBotoes = graficos.map { it.titulo },
                onBotaoClick = { index -> navController.navigate("grafico/${index - 1}") }
            )
        }
        composable("tela3") {
            Tela3() // tela de instruções
        }
        composable("grafico/{index}") { backStackEntry ->
            val index = backStackEntry.arguments?.getString("index")?.toIntOrNull() ?: 0
            // Obtém os dados do gráfico correspondente de Data.kt
            val grafico = graficos.getOrNull(index)
            TelaGraficoI(  // visualização dos gráficos
                estadoJson = grafico?.arquivoJson ?: "arquivo_padrao.json",
                videoUrl = grafico?.videoUrl ?: "https://www.youtube.com/watch?v=dQw4w9WgXcQ", // Mantido para uso futuro
                texto = grafico?.texto ?: "",
                listaParametros = grafico?.listaParametros ?: emptyList()
            )
        }
    }
}

@OptIn(UnstableApi::class)
@Composable
fun TelaVideo(navController: NavController) {
    val context = LocalContext.current
    val videoUri = "android.resource://${context.packageName}/raw/intro" // Caminho do vídeo
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            val mediaItem = MediaItem.fromUri(Uri.parse(videoUri))
            setMediaItem(mediaItem)
            prepare()
            playWhenReady = true // Reproduz automaticamente
        }
    }

    // Monitora o fim do vídeo para trocar para Tela1
    LaunchedEffect(exoPlayer) {
        exoPlayer.addListener(object : Player.Listener {
            override fun onPlaybackStateChanged(state: Int) {
                if (state == Player.STATE_ENDED) {
                    navController.navigate("tela1") { popUpTo("telaVideo") { inclusive = true } }
                }
            }
        })
    }

    AndroidView(
        factory = { context ->
            PlayerView(context).apply {
                player = exoPlayer
                useController = false // Remove botões de controle
                resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FILL // Estica para ocupar a tela
            }
        },
        modifier = Modifier.fillMaxSize()
                            .padding(
                                end = WindowInsets.navigationBars.asPaddingValues().calculateEndPadding(LayoutDirection.Ltr)
                            )
    )

    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }
}


@Composable // Tela inicial
fun Tela1(onIniciarClick: () -> Unit, onInstrucoesClick: () -> Unit, onReverVideoClick: () -> Unit) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                end = WindowInsets.navigationBars.asPaddingValues().calculateEndPadding(LayoutDirection.Ltr)
            )
            .background(color = Color(0xFF2E7D32)) // Fundo verde escuro
    ) {
        // Imagem de fundo
        Image(
            painter = rememberImagePainter(R.drawable.imagem1),
            contentDescription = "Fundo",
            contentScale = ContentScale.FillBounds, // Estica a imagem para ocupar todo o espaço
            modifier = Modifier.fillMaxSize()
        )

        // Coluna centralizada para os botões
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            // Botão "Iniciar"
            Button(
                onClick = onIniciarClick,
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2E7D32), // Verde
                    contentColor = Color.White // Texto branco
                ),
                border = BorderStroke(3.dp, Color.Black)
            ) {
                Text(text = "Iniciar", fontSize = 30.sp)
            }

            Spacer(modifier = Modifier.height(16.dp)) // Espaçamento

            // Botão "Instruções"
            Button(
                onClick = onInstrucoesClick,
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2E7D32),
                    contentColor = Color.White
                ),
                border = BorderStroke(3.dp, Color.Black)
            ) {
                Text(text = "Instruções", fontSize = 30.sp)
            }
        }
/*
        // Imagem pequena no canto inferior direito - TIRA ESSE PRA POR NA PLAYSTORE
        Image(
            painter = rememberImagePainter(R.drawable.imagem2),
            contentDescription = "Ícone Link",
            modifier = Modifier
                .size(110.dp) // Tamanho da imagem pequena
                .align(Alignment.BottomEnd) // Alinha no canto inferior direito
                .padding(16.dp) // Espaçamento da borda
                .clickable {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://chat.whatsapp.com/LmQd9eHCqRu85Htdu143Ht"))
                    context.startActivity(intent)
                }
        )
*/

        // Nova imagem no canto superior esquerdo (imagem3) - Reproduzir vídeo de introdução
        Image(
            painter = rememberImagePainter(R.drawable.imagem3),
            contentDescription = "Rever Vídeo",
            modifier = Modifier
                .size(110.dp)
                .align(Alignment.TopStart)
                .padding(16.dp)
                .clickable { onReverVideoClick() } // Chama a função para exibir o vídeo
        )

        // Texto "versão 1.x" no canto inferior esquerdo - Tirei pra publicar na play store
        /*
        Text(
            text = "Versão 1.5",
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.BottomStart) // Alinha no canto inferior esquerdo
                .padding(16.dp) // Espaçamento da borda
        )
        */
    }
}

@Composable // lista de gráficos
fun Tela2(listaDeBotoes: List<String>, onBotaoClick: (Int) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                end = WindowInsets.navigationBars.asPaddingValues().calculateEndPadding(LayoutDirection.Ltr)
            )
            .background(color = Color(0xFF2E7D32)) // Cor verde escuro de fundo
    ) {
        // Imagem de fundo
        Image(
            painter = rememberImagePainter(R.drawable.imagem1),
            contentDescription = "Fundo",
            contentScale = ContentScale.FillBounds, // Estica a imagem para ocupar todo o espaço
            modifier = Modifier.fillMaxSize()
        )

        // Centralização da LazyColumn
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center // Centraliza o LazyColumn no meio da tela
        ) {
            LazyColumn(
                modifier = Modifier
                    .width(200.dp), // Define largura fixa para os botões
                verticalArrangement = Arrangement.spacedBy(8.dp) // Espaçamento vertical
            ) {
                itemsIndexed(listaDeBotoes) { index, texto ->
                    Button(
                        onClick = { onBotaoClick(index + 1) },
                        shape = RectangleShape, // Botões com formato quadrado
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2E7D32), // Cor verde
                            contentColor = Color.White // Cor do texto
                        ),
                        border = BorderStroke(3.dp, Color.Black), // Contorno preto
                        modifier = Modifier
                            .fillMaxWidth() // Ocupa a largura definida pelo LazyColumn
                            .padding(horizontal = 8.dp) // Padding horizontal
                    ) {
                        Text(
                            text = texto,
                            fontSize = 18.sp, // Tamanho da fonte
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

@Composable // Tela de instruções
fun Tela3() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                end = WindowInsets.navigationBars.asPaddingValues().calculateEndPadding(LayoutDirection.Ltr)
            )
            .background(color = Color(0xFF2E7D32)), // Fundo verde escuro
        contentAlignment = Alignment.Center
    ) {
        // Imagem de fundo
        Image(
            painter = rememberImagePainter(R.drawable.imagem1),
            contentDescription = "Fundo",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        // Retângulo centralizado
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.9f)
                .background(color = Color(0xFF2E7D32)) // Cor do retângulo
                .border(width = 3.dp, color = Color.Black), // Borda preta
            contentAlignment = Alignment.Center // Centraliza o texto
        ) {
            LazyColumn(
                modifier = Modifier.padding(20.dp) // Adiciona padding em toda a coluna
                , horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Text(
                        text = "INSTRUÇÕES",
                        color = Color.White,
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp) // Espaçamento inferior
                    )
                }
                item {
                    Text(
                        text = """          
                            Arraste a tela para ler até o final
                            - Na tela inicial, clique no botão "Iniciar" para ver a lista de conteúdos
                            - Escolha um conteúdo e clique no botão
                            - Ele irá abrir uma ferramenta preparada para ajudar no aprendizado daquele assunto
                            - No canto direito superior haverá um botão que abre um vídeo no Youtube explicando como usar aquela ferramenta
                            - Veja o vídeo para uma breve explicação do assunto e de como usar a ferramenta
                            - Em cada ferramenta, você pode editar as variáveis e equações no lado esquerdo da tela para mudar os números
                            - Para retornar ao estado original, basta voltar na tela anterior e abrir novamente a ferramenta 
                            - Teste exemplos diferentes em cada aula para exercitar! Tente resolver as contas no papel e compare os resultados!
                            """.trimIndent(),
                        color = Color.White,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Justify,
                        lineHeight = 35.sp
                    )
                }
            }
        }

    }
}

@Composable  // tela que mostra os gráficos
fun TelaGraficoI(
    estadoJson: String,
    videoUrl: String,
    texto: String,
    listaParametros: List<String>
) {
    val context = LocalContext.current
    val server = remember { LocalWebServer(context) }
    var isServerReady by remember { mutableStateOf(false) } // Estado para controlar a inicialização do servidor
    var carregarGrafico by remember { mutableStateOf(false) }
    var webViewRef by remember { mutableStateOf<WebView?>(null) }

    val valoresParametros = rememberSaveable(listaParametros) {
        mutableStateOf(List(listaParametros.size) { "" })
    }

    // Inicializa o servidor de forma assíncrona
    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            if (!server.isAlive) {
                server.start()
                while (!server.isAlive) {
                    delay(100) // Aguarda de forma assíncrona sem bloquear a UI
                }
            }
            isServerReady = true // Marca o servidor como pronto
        }
    }

    fun aplicarParametrosNaWebView(valores: List<Int>) {
        val payload = valores.joinToString(prefix = "[", postfix = "]")
        webViewRef?.evaluateJavascript("window.setParametros($payload);", null)
    }

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                end = WindowInsets.navigationBars.asPaddingValues().calculateEndPadding(LayoutDirection.Ltr)
            )
    ) {
        Box(
            modifier = Modifier
                .weight(0.75f)
                .fillMaxHeight()
        ) {
            if (isServerReady && carregarGrafico) {
                AndroidView(
                    factory = { androidContext ->
                        WebView(androidContext).apply {
                            settings.javaScriptEnabled = true
                            settings.domStorageEnabled = true
                            settings.loadWithOverviewMode = true
                            settings.useWideViewPort = true
                            settings.allowFileAccess = true
                            settings.allowContentAccess = true
                            settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING
                            webViewClient = object : WebViewClient() {
                                override fun onPageFinished(view: WebView?, url: String?) {
                                    super.onPageFinished(view, url)
                                    val numeros = valoresParametros.value.map { it.toIntOrNull() ?: 0 }
                                    aplicarParametrosNaWebView(numeros)
                                }
                            }
                            layoutParams = LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.MATCH_PARENT
                            )
                            loadUrl("http://localhost:12346/grafico.html?json=$estadoJson")
                        }.also { webViewRef = it }
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        val barraLateralScroll = rememberScrollState()

        Column(
            modifier = Modifier
                .weight(0.25f)
                .fillMaxHeight()
                .background(Color(0xFF2E7D32))
                .padding(16.dp)
                .verticalScroll(barraLateralScroll),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = texto,
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            listaParametros.forEachIndexed { index, nomeParametro ->
                OutlinedTextField(
                    value = valoresParametros.value[index],
                    onValueChange = { novoValor ->
                        if (novoValor.isEmpty() || novoValor.matches(Regex("^-?\\d+$"))) {
                            valoresParametros.value = valoresParametros.value.toMutableList().also { it[index] = novoValor }
                        }
                    },
                    label = { Text(nomeParametro) },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        disabledContainerColor = Color.White
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val numeros = valoresParametros.value.map { it.toIntOrNull() ?: 0 }
                    if (!carregarGrafico) {
                        carregarGrafico = true
                    } else {
                        aplicarParametrosNaWebView(numeros)
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1B5E20),
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Calcular")
            }
        }
    }

    // Mantido para uso futuro
    @Suppress("UNUSED_VARIABLE")
    val urlVideoMantida = videoUrl

    // Stop the server when leaving the composable
    DisposableEffect(Unit) {
        onDispose {
            server.stop()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewTela1() {
    Tela1(
        onIniciarClick = {},
        onInstrucoesClick = {},
        onReverVideoClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTela2() {
    val listaDeBotoes = listOf("Gráfico 1", "Gráfico 2", "Gráfico 3")
    Tela2(listaDeBotoes = listaDeBotoes, onBotaoClick = {})
}

@Preview(showBackground = true)
@Composable
fun PreviewTelaGraficoI() {
    TelaGraficoI(
        estadoJson = "DaviEGolias.json",
        videoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ", // URL padrão
        texto = "Texto de exemplo",
        listaParametros = listOf("a", "b")
    )
}
