## Projeto Twitter - Relatório

1. O que fez?
    - Fiz o [projeto twitter](https://github.com/qxcodepoo/arcade/blob/master/base/025/Readme.md)

2. Com quem fez?
    - Sozinho, com ajuda de alguns fóruns na web.

3. Como fez?
    - Criei "rotas" onde o início é usado para fazer login e criar o usuário. Para fazer o login, passa-se o nome de usuário.
    - A outra "rota" é após o login de usário, nela é onde o usuário faz todas as suas operações.
    - Dessa vez, tentei fazer algo diferente, separei as classes em pacotes, para evitar confusão:
        - As classes de exceções ficam na pasta `exceptions`
        - As classes dos modelos ficam em `models`
        - As classes de controle ficam em `controller`
        - As classes que fazem a interação com o usuário ficam em `view`
        - Uma classe de auxílio fica em `util`
    - Em alguns métodos do controller e dos modelos não possui validações pois para que o usuário realize as operações ele deve passar pela autenticação (login) passando seu usuário.
    
4. O que aprendeu?
    - Nada que se deva ser mencionado, mas foi bem divertido implementar.
    - Auxiliou na minha lógica.
5. Quanto tempo demorou?
    - Cerca de uma hora e meia (90 min)