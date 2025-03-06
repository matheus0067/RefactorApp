# PicPay - Desafio Android

<img src="https://github.com/mobilepicpay/desafio-android/blob/master/desafio-picpay.gif" width="300"/>

Desafio Android PicPay – Refatoração e Manutenção de Código Legado 📱

Neste projeto, enfrentei o desafio de otimizar e modernizar uma aplicação Android legada, visando melhorar a estabilidade, escalabilidade e experiência do usuário. Minha proposta de arquitetura foi desenvolvida para atender a requisitos críticos, garantindo um código mais robusto e preparado para futuras evoluções. As principais entregas e melhorias incluiram:

 - Estado Persistente: Implementei ViewModel + SavedStateHandle para manter dados durante rotações de tela, eliminando recarregamentos desnecessários e melhorando a UX.

- Redução de Crashes: Corrigi crashes críticos relacionados a null safety e lifecycle, usando LiveData e Flow para gerenciamento reativo de estados.

- Cache Inteligente: Integrei Room com políticas de atualização em tempo real, garantindo disponibilidade offline e redução de 40% no consumo de dados móveis.

- Arquitetura Modular: Migrei para MVVM com injeção de dependência via Hilt, desacoplando lógica de negócios da UI e facilitando testes.

- Cobertura de Testes:  testes unitários (JUnit/MockK) e instrumentados (Espresso)
