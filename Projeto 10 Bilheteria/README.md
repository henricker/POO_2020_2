## Projeto Bilheteria - Relatório

1. O que fez?
    - Fiz o [projeto bilheteria](https://github.com/qxcodepoo/arcade/tree/master/base/028)

2. Com quem fez?
    - Sozinho, com ajuda de alguns fóruns na web

3. Como fez?
    - O projeto constitui dos modelos `Event`, `Person`, `Sale`, e `Sector` são eles que representam o sistema. Eles se encontram na pasta `models`
    - Possui um controller `TicketOffice` que é o modelo da bilheteria de fato, é nela onde há o controle de todas as demais classes. Ela se encontra na pasta `controller`
    - Como visto em aula, utilizei e abusei da criação de objetos de exceções, eles estão na pasta `exceptions`.
    - Também crei um modelo que serve apenas para converter valores double em apenas duas casas decimais, ele se encontra na pasta `util`. Além de um controller para enviar as mensagens e receber o input do usuário com o JOptionPane.
    - Utilizo uma classe específica chamada `View` para controlar a interação com o usuário. Se encontra na pasta `view`
    - Em todos os modelos, busquei o "equilíbrio perfeito" ( mesmo que não esteja kkkkkk). Em cada classe há apenas aquilo que ela pode fazer, nada de mais nem de menos.

4. O que aprendeu?
    - Durante a aula, aprendi a como utilizar a sintaxe de exceções, que é a mesma de JavaScript e python. E acabei pesquisando sobre como criar meus próprios modelos de exceções.
    - Auxiliou no desenvolvimento da minha lógica.

5. Demorou quanto tempo?
    - Cerca de 90 min.