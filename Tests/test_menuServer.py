from menuServer import index


def test_index():
    assert index() == "Hello, world!"

