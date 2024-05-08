def binS(arr, data, leftIndex, rightIndex):
    midIndex = (leftIndex + rightIndex) // 2
    dataIndex = -1
    
    if (len(arr)==0) or(leftIndex == rightIndex and arr[midIndex] != data):
        return dataIndex
    
    if arr[midIndex] == data:
        dataIndex = midIndex
    elif arr[midIndex] > data:
        dataIndex = binS(arr, data, leftIndex, midIndex - 1)
    elif arr[midIndex] < data:
        dataIndex = binS(arr, data, midIndex + 1, rightIndex)
    
    return dataIndex

if __name__ == "__main__":
    data = 5
    list = []
    print(data, "is present at index", binS(list, data, 0, len(list) - 1))