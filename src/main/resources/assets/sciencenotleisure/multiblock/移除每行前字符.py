def process_file(input_file, output_file, n):
    with open(input_file, 'r', encoding='utf-8') as file:
        lines = file.readlines()

    # 移除每行的前5个字符和倒数第2个字符
    processed_lines = [line[5:-2] + line[-1] for line in lines]

    # 合并行
    merged_lines = ['' for _ in range(n)]
    for i in range(len(processed_lines)):
        merged_lines[i % n] += processed_lines[i].rstrip('\n') + ','

    result_lines = ['' for _ in range(n)]
    for i in range(n):
        result_lines[i] = merged_lines[i].rstrip(',')

    # 写入最终的输出文件
    with open(output_file, 'w', encoding='utf-8') as new_file:
        for line in result_lines:
            new_file.write(line + '\n')

# 示例用法
input_file = 'input.txt'  # 输入文件路径
output_file = 'new_file.txt'  # 输出文件路径
n = 3  # 需要合并的行数

process_file(input_file, output_file, n)