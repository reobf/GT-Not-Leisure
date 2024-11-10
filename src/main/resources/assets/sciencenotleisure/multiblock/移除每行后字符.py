def remove_last_2_chars(input_file, output_file):
    with open(input_file, 'r', encoding='utf-8') as file:
        lines = file.readlines()

    with open(output_file, 'w', encoding='utf-8') as file:
        for line in lines:
            file.write(line[:-2] + line[-1])  # 移除倒数第 3 个和倒数第 2 个字符，但保留最后一个字符（换行符）

input_file = 'input.txt'  # 输入文件路径
output_file = 'output.txt'  # 输出文件路径

remove_last_2_chars(input_file, output_file)
