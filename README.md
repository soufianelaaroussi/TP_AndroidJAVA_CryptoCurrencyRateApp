# Application Android de Conversion de Taux de Change de Cryptomonnaie

## Description
Cette application Android a été développée par un développeur mobile dans le but de fournir aux utilisateurs un outil pratique pour convertir les taux de change des cryptomonnaies. L'application permet aux utilisateurs de sélectionner une cryptomonnaie, une devise fiduciaire, et d'obtenir le taux de change correspondant. Pour ce faire, l'application utilise la bibliothèque Volley pour consommer un service web. Les taux de change sont récupérés à partir de l'URL suivante : `https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/{crypto_symbol}.json`, où `{crypto_symbol}` doit être remplacé par le symbole de la cryptomonnaie choisie.

## Fonctionnalités
- Choisissez une cryptomonnaie et une devise fiduciaire pour la conversion des taux de change.
- Utilise la bibliothèque Volley pour une consommation efficace des services web.
- Taux de change en temps réel obtenus à partir de l'API de devises.

## Pour Commencer
1. Clonez le dépôt sur votre machine locale.
   ```bash
   git clone https://github.com/soufianelaaroussi/TP_AndroidJAVA_CryptoCurrencyRateApp.git
   ```

2. Ouvrez le projet dans votre environnement de développement Android préféré (par exemple, Android Studio).

3. Compilez et exécutez l'application sur un émulateur Android ou un appareil physique.

4. Explorez l'application, sélectionnez une cryptomonnaie et une devise fiduciaire, et obtenez le taux de change correspondant.

## Dépendances
- Bibliothèque Volley : Assurez-vous que la bibliothèque Volley est intégrée au projet. Vous pouvez trouver la bibliothèque et les instructions sur la manière de l'intégrer [ici](https://github.com/google/volley).

## Point d'API
Les taux de change sont récupérés à partir de l'URL suivante :
```
https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/{crypto_symbol}.json
```
Remplacez `{crypto_symbol}` dans l'URL par le symbole de la cryptomonnaie choisie.


