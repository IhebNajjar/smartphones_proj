# smartphones_proj

Mini projet **Sprint 01** - Spring Boot 3 + Angular (partie Backend).

Entites : **Marque** (1) <-> **Smartphone** (Many) via une relation **OneToMany**.

## Entites

### Marque (cote "1")
| Attribut        | Type   |
|-----------------|--------|
| idMarque        | Long   |
| nomMarque       | String |
| paysOrigine     | String |
| dateFondation   | Date   |

### Smartphone (cote "Many")
| Attribut           | Type   |
|--------------------|--------|
| idSmartphone       | Long   |
| libelleSmartphone  | String |
| prixReference      | Double |
| quantiteEnStock    | Long   |
| dateSortie         | Date   |

> Les attributs sont differents de ceux du cours (idProduit, nomProduit, prixProduit, dateCreation).
> La liste des Smartphone dans Marque s'appelle `modeles` et le service expose `tousLesSmartphones()`.

## Prerequis

- Java 17+
- Maven 3.8+
- XAMPP : demarrer **MySQL** (port 3306) et **Apache** depuis le panneau XAMPP,
  puis acceder a phpMyAdmin (http://localhost/phpmyadmin).

## Configuration

`src/main/resources/application.properties` :
- base MySQL `smartphones_db` creee automatiquement (`createDatabaseIfNotExist=true`)
- `spring.jpa.show-sql=true`
- `spring.jpa.hibernate.ddl-auto=update`
- `server.servlet.context-path=/api`

Profil H2 (sans XAMPP) : `mvn spring-boot:run -Dspring-boot.run.profiles=h2`

## Lancer le projet

```bash
mvn spring-boot:run
```

Application disponible sur : `http://localhost:8080/api`

Des donnees d'exemple sont inserees au demarrage (Apple, Samsung, Xiaomi) par `SeedDataRunner`.

## Web Services REST (cree a la main - Atelier 03)

### Marque (`/marque`)
| Methode | URL | Description |
|---------|-----|-------------|
| GET | /api/marque | toutes les marques |
| GET | /api/marque/{idMarque} | consulter une marque |
| GET | /api/marque/byNom?nom=Apple | marques par nom |
| GET | /api/marque/fondeesApres?date=2000-01-01 | marques fondees apres une date |
| POST | /api/marque | ajouter une marque |
| PUT | /api/marque | modifier une marque |
| DELETE | /api/marque/{idMarque} | supprimer une marque |

### Smartphone (`/smartphone`)
| Methode | URL | Description |
|---------|-----|-------------|
| GET | /api/smartphone | tous les smartphones |
| GET | /api/smartphone/{idSmartphone} | consulter un smartphone |
| GET | /api/smartphone/byLibelle?libelle=iPhone | smartphones par libelle exact |
| GET | /api/smartphone/byMarque/{nomMarque} | smartphones d'une marque (par nom) |
| GET | /api/smartphone/byMarqueId/{idMarque} | smartphones d'une marque (par id) |
| GET | /api/smartphone/plusCherQue/{prixMin} | smartphones plus chers que prixMin |
| POST | /api/smartphone | ajouter un smartphone |
| POST | /api/smartphone/{idMarque}/add | ajouter un smartphone dans une marque |
| PUT | /api/smartphone | modifier un smartphone |
| DELETE | /api/smartphone/{idSmartphone} | supprimer un smartphone |

### Exemple - ajouter un Smartphone dans une Marque (Postman)

```
POST http://localhost:8080/api/smartphone/1/add
Content-Type: application/json

{
  "libelleSmartphone": "Galaxy A54",
  "prixReference": 449.0,
  "quantiteEnStock": 90,
  "dateSortie": "2023-03-15"
}
```

## Spring Data REST (genere automatiquement)

Avec `@RepositoryRestResource`, des API CRUD sont exposees automatiquement :
- `http://localhost:8080/api/marques`
- `http://localhost:8080/api/smartphones`

Fonctionnalites d'atelier 03 :
- **IDs exposes** dans le JSON (via `RepositoryRestConfig`)
- **Tri / pagination** : `GET /api/smartphones?sort=prixReference,desc&page=0&size=2`
- **AJOUT** : `POST /api/smartphones`
- **MODIF partielle** : `PATCH /api/smartphones/{id}`
- **Projections** (restreindre les champs) :
  `GET /api/smartphones?projection=sansDetails`

## Tests (Atelier 01)

```bash
mvn test
```
Les tests utilisent le profil H2 et couvrent : ajout, consultation, modification,
suppression et interrogation par attribut non cle / par idMarque / JPQL.

## Structure du projet

```
src/main/java/com/example/smartphonesproj
├── config          -> RepositoryRestConfig (expose les IDs + CORS)
├── entities        -> Marque, Smartphone
├── projections     -> MarqueProjection, SmartphoneProjection
├── repositories    -> MarqueRepository, SmartphoneRepository
├── restcontrollers -> MarqueRestController, SmartphoneRestController
├── runner          -> SeedDataRunner (donnees d'exemple)
└── services        -> MarqueService, SmartphoneService
```