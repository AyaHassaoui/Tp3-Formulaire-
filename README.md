
# 📱 Application Android – Formulaire & Récapitulatif

## 🎯 Objectif du TP
Créer une application Android composée de **deux écrans** :

- Un **formulaire** permettant de saisir :
  - Nom et prénom  
  - E-mail  
  - Téléphone  
  - Adresse  
  - Ville  

- Un **écran récapitulatif** affichant les données saisies après validation.

### Ce TP permet d’apprendre :
- La création d’interfaces XML (layouts)  
- L’utilisation de `EditText`, `Button` et `TextView`  
- La navigation entre deux activités avec un **Intent explicite**  
- Le passage de données avec `putExtra()` et `getStringExtra()`  
- L’utilisation de `finish()` pour revenir à l’écran précédent  

---

## 🧱 Structure du projet Android Studio

```

app/
├─ java/com.example.formnav/
│   ├─ MainActivity.java
│   └─ Screen2Activity.java
├─ res/
│   ├─ layout/
│   │   ├─ activity_main.xml
│   │   └─ activity_screen2.xml
│   └─ values/
│       └─ strings.xml
└─ AndroidManifest.xml

````

---

## 🪜 Étape 1 – Création du projet
1. Ouvrir **Android Studio**  
2. Sélectionner **New Project → Empty Activity**  
3. Nom du projet : **FormNav**  
4. Langage : **Java**  
5. Minimum SDK : **24 ou supérieur**  
6. Cliquer sur **Finish**  

> Android Studio crée automatiquement la structure du projet.

---

## 🧩 Étape 2 – Interface du Formulaire (`activity_main.xml`)
Créer la première interface contenant plusieurs champs de saisie (`EditText`) pour :

- Nom et prénom  
- E-mail  
- Téléphone  
- Adresse  
- Ville  

Ajouter un bouton **“Envoyer”** pour lancer la seconde activité.

### Conseils :
- Utiliser un `LinearLayout` vertical dans un `ScrollView`  
- Définir des `hint` et des `inputType` adaptés (`textPersonName`, `textEmailAddress`, `phone`, etc.)  
- Vérifier que chaque champ possède un `@+id` unique  

> Cet écran correspond à la **saisie des informations utilisateur**.

---

## 📄 Étape 3 – Interface du Récapitulatif (`activity_screen2.xml`)
Créer une interface pour **afficher les informations saisies** :

- Un `TextView` principal affiche le texte formaté  
- Un bouton **“Retour”** pour revenir au formulaire  
- Disposition en `LinearLayout` avec `padding`

---

## ⚙️ Étape 4 – Logique du Formulaire (`MainActivity.java`)
1. Récupérer les vues (`EditText`, `Button`) avec `findViewById()`  
2. Lire les valeurs saisies lors du clic sur **“Envoyer”**  
3. Vérifier que les champs obligatoires (**Nom** et **Email**) ne sont pas vides  
4. Si tout est valide, créer un **Intent explicite** :  

```java
Intent i = new Intent(MainActivity.this, Screen2Activity.class);
i.putExtra("nom", sNom);
i.putExtra("email", sEmail);
i.putExtra("phone", sPhone);
i.putExtra("adresse", sAdresse);
i.putExtra("ville", sVille);
startActivity(i);
````

---

## 🧠 Étape 5 – Logique du Récapitulatif (`Screen2Activity.java`)

* Récupérer l’Intent reçu depuis la première activité
* Extraire les données envoyées avec `getStringExtra()`
* Construire un texte affichant : nom, e-mail, téléphone, adresse, ville
* Afficher ces informations dans le `TextView`
* Gérer le clic sur **Retour** avec :

```java
btnRetour.setOnClickListener(v -> finish());
```

---

## 🧾 Étape 6 – Déclaration dans `AndroidManifest.xml`

Déclarer les deux activités :

```xml
<application ...>
    <activity android:name=".Screen2Activity" />

    <activity
        android:name=".MainActivity"
        android:exported="true">
        <intent-filter>
            <action android:name="android.intent.action.MAIN" />
            <category android:name="android.intent.category.LAUNCHER" />
        </intent-filter>
    </activity>
</application>
```

> `MainActivity` est l’écran principal.
> `Screen2Activity` est appelée via un Intent explicite.

---

## ▶️ Étape 7 – Test de l’application

* Lancer l’application sur un **émulateur** ou un **téléphone réel**
* Remplir les champs du formulaire
* Cliquer sur **Envoyer**
* Vérifier que les données s’affichent correctement dans l’écran récapitulatif
* Cliquer sur **Retour** pour revenir au formulaire

---

## 🎥 Vidéo de démonstration

(https://github.com/user-attachments/assets/a6e1d2d5-cce2-4324-b0cc-f75efa5207c5)


