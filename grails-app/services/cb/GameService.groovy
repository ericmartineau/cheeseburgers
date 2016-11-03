package cb

import grails.transaction.Transactional

@Transactional
class GameService {

    def findLocation(String location) {
        return GameLocations.findLocation(location)
    }

    def getPaths(String location) {
        return GameLocations.findPaths(location)
    }

    def getLocations() {
        return GameLocations.locations
    }


//    function house() {
//    }
//
//    function upstairs() {
//        var found = prompt ('you found a loose floor piece should you lift it up yes or no')
//
//
//        if (found == 'no'){
//            console.log( 'why not')
//        }
//
//        if (found === 'yes' ){
//            var look=prompt('you find a diamond should you keep it?')
//            if (look === 'yes'){
//                bag['money']+=50
//                bag ['diamond']=1
//
//                alert("You stole the diamond from an angry troll.  He attacked you but you escaped.")
//                health -= 20
//            }
//
//        }
//    }
//
//    function  street() {
//    }
//
//    function arena (){
//        if(!isInBag('boat')) {
//            alert('you do not have a boat. you may not travel on water.')
//            currentLocation = 'lake'
//        }
//    }
//
//    function forest() {
//        var woods = prompt('your in the woods. you find light should you go towards it?')
//        if (woods === 'yes') {
//            var indians = prompt('you found some indians should you trade')
//            if (indians === 'yes') {
//
//                var indianStuff = {
//                    'sword': 25,
//                    'bow': 50,
//                    'water': 10,
//                    'key': 100
//                };
//
//                store(indianStuff);
//
//            }
//        }
//    }
//
//    function lake() {
//        if(stuff['lake']['violin'] > 0) {
//            if(Math.random() < 0.5) {
//                delete stuff['lake']['violin']
//                alert("There is a leprechaun playing your violin.  He gave you a shovel and $50");
//                addToBag('shovel', 1)
//                addToBag('money', 50)
//            }
//        }
//    }
//
//    function tree() {
//        if (isInBag('old boot')) {
//            Math.random
//        }()< 0.8
//    }
//
//    function city() {
//        var buy = prompt("You ran into some gypsies.  Do you want to trade?");
//        if(buy === 'yes') {
//            var gypsyStore = {
//                'violin': 40,
//                'matches': 10,
//                'helmet': 20,
//                'cd': 5
//            }
//            store(gypsyStore)
//        }
//    }
//
//    function skyscraper() {
//    }
//
//    function beach() {
//        if(isInBag('boat')) {
//            var sail = prompt("We noticed you have a boat.  Do you want to sail?")
//            if(sail === 'yes') {
//                var sailing = true
//
//                while(sailing === true) {
//                    if(isInBag('shovel')) {
//                        if(Math.random() > 0.9) {
//                            alert("You found some treasure!!  You get $100")
//                            addToBag('money', 100)
//                        }
//                    }
//                    sailing = (prompt("Do you want to keep sailing?") === 'yes')
//                }
//            }
//        }
//    }
//
//    function island() {
//    }
//
//    function sewer () {
//
//    }
//
//    function dungeon() {
//        if(day === false || Math.random() < 0.33) {
//            var guess = parseInt(prompt("A troll appeared and asks you to guess the magic number between 1 and 3:"));
//            var actualAnswer = randomNumber(1, 3);
//            if (guess === actualAnswer) {
//                alert("You guessed the right number!  The troll gave you $50")
//                addToBag('money', 50)
//            } else {
//                if (isInBag('sword')) {
//                    if (Math.random() < 0.5) {
//                        alert("You guessed the wrong answer, and the troll attacked you.  You had a sword and defeated the troll.  " +
//                            "He dropped $25, but you lost 10 health.");
//                        addToBag('money', 25)
//                        health -= 10
//                        if(Math.random()>0.9){
//                            alert("awesome!! the troll had a boat!!")
//                            addToBag('boat',1)
//                        }
//                    } else {
//                        alert("You guessed wrong, and the troll attacked you.  You had a sword, but you got defeated.  You lost 20 health");
//                        health -= 20
//                    }
//                } else {
//                    alert("You guessed wrong, and the troll attacked you.  You didn't have a sword, and you lost 20 health");
//                    health -= 20
//                }
//            }
//        }
//    }
//    var day=true
//    var timer = new Date().getTime()
//    var currentLocation = "house";
//
//    var bag = {}
//    bag['water'] = 3
//    bag['money'] = 100
//    var health = 100
//
//    startGame()
//
//    function startGame() {
//        try {
//            doLocation();
//        } catch (e) {
//            alert("Game over: " + e.message);
//        }
//    }
//
//    function isInBag(itemName) {
//        return bag[itemName] > 0
//    }
//
//    function doLocation() {
//
//        var elapsedMilliseconds = new Date().getTime() - timer;
//        if(elapsedMilliseconds > 150000) {
//            if(day === true) {
//                alert("It is night!")
//                day = false
//            }
//            else {
//                alert("It is day!")
//                day = true
//            }
//            timer = new Date().getTime()
//        }
//
//
//        eval(currentLocation + "()");
//
//        health -= 2
//        var locationMessage = 'You are in the ' + currentLocation + "\n"
//        if(health <= 0) {
//            throw {message:"You died!!"}
//        } else if (health < 20) {
//            locationMessage += "Your health is low: " + health + ".  Drink some water."
//        }
//        alert(locationMessage);
//
//
//        var possiblePlaces = locations[currentLocation]
//        var stuffHere = stuff[currentLocation]
//
//
//        var exited = false
//        while(!exited) {
//            var stuffArray = []
//            for(var item in stuffHere) {
//                stuffArray.push(item);
//            }
//
//            var message = "";
//            if(stuffArray.length > 0) {
//                message += "There are items on the ground: " +  stuffArray.join(", ") + ".  You can pick them up by using 'get'\n";
//            }
//
//            for(var place in possiblePlaces) {
//                message += "Type 'go " + place + "' to get to the " + possiblePlaces[place] + "\n"
//            }
//
//            message += "What would you like to do?"
//
//            var command = prompt(message);
//            if(command == null) {
//                alert("You didn't provide a command");
//            } else if (command.startsWith("go ")) {
//                var newLocation = command.substr(3)
//                if(possiblePlaces[newLocation]) {
//                    currentLocation = possiblePlaces[newLocation]
//                    exited = true
//                } else {
//                    alert("You picked an invalid direction.  Please try again.")
//                    continue;
//                }
//            } else if(command.startsWith("get ")) {
//                var itemToGet = command.substr(4);
//                if(!stuffHere[itemToGet]) {
//                    alert("There isn't that item here");
//                } else {
//                    addToBag(itemToGet, stuffHere[itemToGet]);
//                    delete stuffHere[itemToGet];
//                }
//            } else if(command == "inventory") {
//                inventory();
//            } else if(command.startsWith("drop ")) {
//                var itemToDrop = command.substr(5);
//                if(!bag[itemToDrop]) {
//                    alert("You don't have any " + itemToDrop + " items");
//                } else {
//                    if(!stuffHere[itemToDrop]) stuffHere[itemToDrop] = 0
//                    stuffHere[itemToDrop] += bag[itemToDrop]
//                    delete bag[itemToDrop]
//                }
//            } else if(command === 'drink') {
//                if(!bag['water'] || bag['water'] <1) {
//                    alert("You don't have any water!");
//                } else {
//                    health += 50;
//                    health = Math.min(health, 100);
//                    bag['water'] -= 1;
//                }
//            } else if(command === 'exit') {
//                inventory()
//                throw {message: 'You chose to exit the game'}
//            }
//        }
//
//        doLocation()
//
//    }
//
//    function addToBag(item, count) {
//        if(!bag[item]) bag[item] = 0;
//        bag[item] += count;
//    }
//
//
//
//    function store(storeItems) {
//        var trading = true;
//
//        var storeMessage = ""
//        storeMessage = "STORE STUFF:\n";
//        for(var item in storeItems) {
//            storeMessage += "    " + item + ": $" + storeItems[item] + "\n";
//        }
//
//        storeMessage += "What item do you want to buy?"
//        while(trading === true) {
//
//            var item = prompt(storeMessage);
//            if(!storeItems[item]) {
//                alert('We dont have that in our store!');
//                continue;
//            }
//            var amount = parseInt(prompt("How many do you want?"));
//            var bought = buyItem(storeItems[item], item, amount);
//            if(bought === false) {
//                alert("You did not have enough money.");
//            }
//            else {
//                alert("You bought the " + item);
//            }
//            var stillTrade = prompt("Do you want to trade again?")
//            if(stillTrade === 'no') {
//                trading = false;
//            }
//        }
//    }
//
//    function buyItem(cost, item, qty) {
//        var totalCost = cost * qty
//        if(bag['money'] >= totalCost) {
//            bag['money'] -= totalCost
//            addToBag(item, qty)
//            return true
//        }
//        else {
//            return false
//        }
//    }
//
//    function inventory() {
//        var message = "";
//        message = "YOUR BAG:\n";
//        for(var item in bag) {
//            message += "    " + item + ": " + bag[item] + "\n";
//        }
//        message += 'your health = ' + health
//        alert(message)
//
//
//    }
//
//    function randomNumber(betweenStart, betweenEnd) {
//        var range = betweenEnd - betweenStart
//        return Math.floor(((Math.random() * 100) % range) + betweenStart);
//    }
//
//
//
//    def serviceMethod() {
//
//    }
}
