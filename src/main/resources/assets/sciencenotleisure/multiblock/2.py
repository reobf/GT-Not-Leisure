def remove_last_char(file_path, output_path):
    with open(file_path, 'r', encoding='utf-8') as file:
        lines = file.readlines()
    
    with open(output_path, 'w', encoding='utf-8') as new_file:
        for line in lines:
            new_file.write(line[:-1] + '\n')  # 删除每行的最后一个字符

# 示例用法
remove_last_char('123.txt', 'output_file.txt')
