<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>CrimeAccuData</title>
    <style>
        .row {
            margin: 1em;
        }
        .description {
            text-align: center;
        }
        .form-control {
            font-size:80%;
        }

    </style>
</head>
<body>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">CrimeAccuData</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#isItSafe">isItSafe?</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#canISteal">canISteal?</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#wheresTheMoney">wheresTheMoney?</a>
            </li>
        </ul>
    </div>
</nav>

<div id="isItSafe" class="card offset-md-3 col-md-6"  style="padding : 0; margin-top: 5em;">
    <div class="card-header text-white bg-dark">
        isItSafe?
    </div>
    <div  class="card-body">
        <h5 class="card-title" style="text-align: center;">PLACEHOLDER</h5>
        <p class="card-text description">PLACEHOLDER</p>
        <div class="row">
            <input class="form-control offset-md-3 col-md-1" type="text" placeholder="GET" readonly style="display:inline-block; text-align:center;  font-weight: bold;">
            <input class="form-control col-md-5" type="text" placeholder="/crimeaccudata/" readonly style="display:inline-block;">
        </div>
        <div class="row">
            <input class="form-control offset-md-3 col-md-1" type="text" placeholder="Output" readonly style="display:inline-block; text-align:center;  font-weight: bold;">
            <input class="form-control col-md-5" type="text" placeholder="??????" readonly style="display:inline-block;">
        </div>
    </div>
</div>

<div id="wheresTheMoney" class="card offset-md-3 col-md-6"  style="padding : 0; margin-top: 5em;">
    <div class="card-header text-white bg-dark">
        canISteal?
    </div>
    <div  class="card-body">
        <h5 class="card-title" style="text-align: center;">PLACEHOLDER</h5>
        <p class="card-text description">PLACEHOLDER</p>
        <div class="row">
            <input class="form-control offset-md-3 col-md-1" type="text" placeholder="GET" readonly style="display:inline-block; text-align:center;  font-weight: bold;">
            <input class="form-control col-md-5" type="text" placeholder="/crimeaccudata/" readonly style="display:inline-block;">
        </div>
        <div class="row">
            <input class="form-control offset-md-3 col-md-1" type="text" placeholder="Output" readonly style="display:inline-block; text-align:center;  font-weight: bold;">
            <input class="form-control col-md-5" type="text" placeholder="" readonly style="display:inline-block;">
        </div>
    </div>
</div>

<div id="wheresTheMoney" class="card offset-md-3 col-md-6"  style="padding : 0; margin-top: 5em;">
    <div class="card-header text-white bg-dark">
        wheresTheMoney?
    </div>
    <div  class="card-body">
        <h5 class="card-title" style="text-align: center;">Determine the wealthiest areas by a given zipcode</h5>
        <p class="card-text description">Enter a legitimate zipcode to find income averages in a 10 km radius of the submitted zipcode.</p>
        <div class="row">
            <input class="form-control offset-md-3 col-md-1" type="text" placeholder="GET" readonly style="display:inline-block; text-align:center;  font-weight: bold;">
            <input class="form-control col-md-5" type="text" placeholder="/crimeaccudata/wheresTheMoney/{zipcode}" readonly style="display:inline-block;">
        </div>
        <div class="row">
            <input class="form-control offset-md-3 col-md-1" type="text" placeholder="Output" readonly style="display:inline-block; text-align:center;  font-weight: bold;">
            <input class="form-control col-md-5" type="text" placeholder="[{ id: 17555, zip: 53704, average: 65,357 }]" readonly style="display:inline-block;">
        </div>
    </div>
</div>


</body>
</html>
