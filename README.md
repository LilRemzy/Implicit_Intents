# Implicit Intents

V tej nalogi sem naredil aplikacijo Implicit Intents, ki vsebuje eno aktivnost (`MainActivity`) s tremi vnosnimi polji in tremi gumbi. Z implicitnimi nameni (`Intent`) aplikacija odpre spletno stran v brskalniku, prikaže lokacijo na zemljevidu in deli besedilo z drugimi aplikacijami. Pri tem sistem sam poišče primerno aplikacijo, ki zna izvesti zahtevano dejanje.

## Cilji

- izdelati novo aplikacijo z imenom `ImplicitIntents` s predlogo Empty Views Activity in privzeto aktivnostjo `MainActivity`,
- v `activity_main.xml` uporabiti korenski `LinearLayout` z navpično usmeritvijo (`android:orientation="vertical"`) in pripraviti tri vnosna polja (`EditText`) ter tri gumbe,
- v `strings.xml` zapisati besedilne vire za gumbe **Open Website**, **Open Location** in **Share This Text** ter za vnosna polja,
- v `MainActivity` pripraviti zasebne reference na gradnike `EditText` in jih v metodi `onCreate()` povezati z `findViewById()`,
- metodo `openWebsite(View view)`: besedilo iz polja pretvoriti v `Uri`, ustvariti implicitni namen z akcijo `Intent.ACTION_VIEW` ter pred zagonom z `resolveActivity(getPackageManager())` preveriti, ali obstaja aplikacija, ki ga zna obdelati,
- metodo `openLocation(View view)`: iz imena lokacije sestaviti URI v obliki `geo:0,0?q=iskana_lokacija` in z `Intent.ACTION_VIEW` odpreti zemljevid,
- metodo `shareText(View view)`: besedilo deliti z razredom `ShareCompat.IntentBuilder` in MIME tipom `text/plain`,
- v `openWebsite` dodati samodejno predpono `https://`, če jo uporabnik pri vnosu izpusti, ter obvestilo (`Toast`), če je polje prazno,
- v `AndroidManifest.xml` dodati element `<queries>`, da `resolveActivity` na novejših različicah Androida pravilno najde aplikacije za `http`, `https` in `geo`,
- spremeniti privzeto ikono aplikacije z orodjem Image Asset Studio (Launcher Icons),
- generirati datoteko `.apk` in aplikacijo namestiti na telefon z Androidom.

## Delovanje aplikacije

| Gumb | Kaj naredi | Uporabljeno |
|------|-----------|-------------|
| **Open Website** | odpre spletno stran, vpisano v prvo polje | `Intent.ACTION_VIEW` + `Uri.parse(url)` |
| **Open Location** | prikaže vpisano lokacijo na zemljevidu | `Intent.ACTION_VIEW` + `geo:0,0?q=lokacija` |
| **Share This Text** | odpre izbirnik aplikacij za deljenje besedila | `ShareCompat.IntentBuilder`, `text/plain` |

## Zaslonske slike aplikacije
<img width="175" height="411" alt="Slika4" src="https://github.com/user-attachments/assets/657a907e-3125-43d8-a937-1147513e5959" />
<img width="175" height="411" alt="Slika5" src="https://github.com/user-attachments/assets/7d1b60e0-c780-4135-b2d9-3d12c5b5c970" />
<img width="175" height="411" alt="Slika6" src="https://github.com/user-attachments/assets/5dcbe268-f5d2-48f7-8faf-39a40ba6fa90" />
<img width="175" height="411" alt="Slika7" src="https://github.com/user-attachments/assets/cef7695c-62d4-4f5d-97f6-00efaa1d99c3" />

## Zagon

1. Projekt odprite v Android Studiu.
2. Aplikacijo zaženite na emulatorju ali telefonu.
3. APK generirate z **Build → Build Bundle(s) / APK(s) → Build APK(s)**.

## Tehnologije

- Java, AndroidX (`AppCompatActivity`, `ShareCompat`)
- `LinearLayout` z navpično usmeritvijo
- Image Asset Studio za ikono aplikacije
