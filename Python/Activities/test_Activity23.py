import pytest

'''@pytest.fixture
def input_list():
    numbers = [0,1,2,3,4,5,6,7,8,9,10]
    return numbers'''

def test_sum(input_list):
    sum = 0

    for number in input_list:
        sum+=number

    assert sum == 55

