# Quiz de bandeiras

Projeto realizado nas aulas de Programação Mobile na UNICID, 
referente ao 4 semestre do curso de ADS (Análise e Desenvolvimento de Sistemas)

## Tech Stack
- JDK 25.0.4.1
- Android Studio

## Pré-requisitos
- Android Studio (versão Flamingo, Giraffe ou superior)

- JDK (Java Development Kit) 11 ou superior

- Git

## Estrutura do Reposítorio
```text
app/
├── manifests/
│   └── AndroidManifest.xml
├── kotlin+java/
│   └── com.example.quizbandeira/
│       ├── MainActivity.java
│       ├── Player.java
│       ├── QuestionOne.java
│       └── QuestionTwo.java
│   └── com.example.quizbandeira (androidTest)/
│       └── ExampleInstrumentedTest.java
│   └── com.example.quizbandeira (test)/
│       └── ExampleUnitTest.java
└── res/
    ├── drawable/
    │   ├── bandeiras.png
    │   ├── brasil.png
    │   ├── ic_launcher_background.xml
    │   ├── ic_launcher_foreground.xml
    │   ├── pessoa.png
    │   └── uzbequistao.jpeg
    ├── layout/
    │   ├── activity_main.xml
    │   ├── activity_question2.xml
    │   └── activity_quiz.xml
    ├── mipmap/
    │   ├── ic_launcher/
    │   └── ic_launcher_round/
    ├── values/
    │   ├── themes/
    │   ├── colors.xml
    │   └── strings.xml
    └── xml/
        ├── backup_rules.xml
        └── data_extraction_rules.xml
```

## Como executar

### 1 - Clonar o repositório
```text
 git clone https://github.com/boregs/app-quiz-bandeiras.git
```

### 2 - Abrir no Android Studio
- Abra o Android Studio.

- Na tela inicial, clique em Open.

- Navegue até o diretório onde clonou o projeto e selecione a pasta raiz.

- Aguarde o Android Studio realizar a indexação dos arquivos e o 
processo de sincronização do Gradle.

### 3. Sincronizar o Gradle
- Se a sincronização não iniciar automaticamente:

- Localize a barra de ferramentas superior.

- Clique no ícone do elefante com uma seta para baixo (Sync Project with Gradle Files).

- Certifique-se de que não há erros de dependência exibidos no painel Build na parte inferior.

### 4. Executar o Aplicativo
- Conecte um dispositivo Android via cabo USB ou inicie um emulador (AVD).

- Selecione o dispositivo desejado no seletor da barra superior.

- Clique no botão `Run ▶` (ou pressione `Shift + F10` / `Ctrl + R`).

- O app será compilado, instalado e aberto na `MainActivity`.