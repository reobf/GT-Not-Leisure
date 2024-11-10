def remove_first_5_chars(input_file, output_file):
    with open(input_file, 'r', encoding='utf-8') as file:
        lines = file.readlines()

    with open(output_file, 'w', encoding='utf-8') as file:
        for line in lines:
            file.write(line[6:])

input_file = 'input.txt'  # 输入文件路径
output_file = 'output.txt'  # 输出文件路径

remove_first_5_chars(input_file, output_file)
