while True:
    player1 = input("Do you choose rock, paper or scissor: ").lower()
    player2 = input("Do you choose rock, paper or scissor: ").lower()

    if(player1 == player2):
        print("Tie")
    elif(player1 == 'rock'):
        if(player2 == 'scissor'):
            print("Rock wins")
        else:
            print("Paper wins")

    elif(player1 == 'paper'):
        if(player2 == 'rock'):
            print("Paper wins")
        else:
            print("Scissor wins")

    elif(player1 == 'scissor'):
        if(player2 == 'paper'):
            print("Scissor wins")
        else:
            print("Rock wins")

    else:
        print("Invalid option")

    repeat = input("Do you wish to play again (Yes/No): ").lower()

    if(repeat == 'yes'):
        pass

    elif(repeat == 'no'):
        raise SystemExit

    else:
        print("Invalid option")
        raise SystemExit
    