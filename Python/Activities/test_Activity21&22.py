import pytest

def test_sum():
     number1 = 10
     number2 = 10

     assert number1+number2 == 20

def test_difference():
    number1 = 10
    number2 = 5

    assert number1-number2 == 5

@pytest.mark.activity
def test_product():
    number1 = 5
    number2 = 4

    assert number1*number2 == 20

@pytest.mark.activity
def test_division():
    number1 = 4
    number2 = 2

    assert number1/number2 == 2