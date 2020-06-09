#language: pt
Funcionalidade: Tasks

Cenario: Criar Tarefa com Sucesso
Dado que cliquei em adicionar uma Tarefa
Quando escrevi "Teste via Selenium" no nome da tarefa
E escrevi "10/10/2030" na data
E clicar em salvar
Entao valido que foi salvo com sucesso

Cenario: Nao deve salvar tarefa sem descricao
Dado que cliquei em adicionar uma Tarefa
E escrevi "10/10/2030" na data
E clicar em salvar
Entao valido que apresentou a messagem: "Fill the task description"

Cenario: Nao deve salvar tarefa sem data
Dado que cliquei em adicionar uma Tarefa
Quando escrevi "Teste via Selenium" no nome da tarefa
E clicar em salvar
Entao valido que apresentou a messagem: "Fill the due date"

Cenario: Nao deve salvar tarefa com data passada
Dado que cliquei em adicionar uma Tarefa
Quando escrevi "Teste via Selenium" no nome da tarefa
E escrevi "10/10/2010" na data
E clicar em salvar
Entao valido que apresentou a messagem: "Due date must not be in past"

Cenario: Deve remover tarefa com sucesso
Dado que cliquei em adicionar uma Tarefa
Quando escrevi "Teste via Selenium" no nome da tarefa
E escrevi "10/10/2030" na data
E clicar em salvar
Entao valido que foi salvo com sucesso
E clico em remover
Entao valido que apresentou a messagem: "Success!"