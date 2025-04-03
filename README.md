# CFBlackScreen

## Описание
CFBlackScreen — это плагин для Minecraft сервера, который позволяет администраторам сервера накладывать эффект "черного экрана" на читеров. Этот эффект визуально затемняет экран у читера, создавая эффект наказания за игру с запрещённым ПО.

## Установка
1. Скачайте [CFBlackScreen.jar](https://github.com/ConderFix/CFBlackScreen/releases/tag/release) и [PacketEvents](http://modrinth.com/plugin/packetevents?version=1.16.5&loader=paper).
2. Переместите его в папку `plugins` вашего сервера.
3. Запустите сервер, чтобы создать файл конфигурации.
4. Настройте параметры конфигурации по необходимости (`plugins/CFBlackScreen/config.yml`).
5. Перезапустите сервер.

## Зависимости
- [PacketEvents](https://github.com/retrooper/packetevents)

## Конфигурация (`config.yml`)
```yaml
ticks: 20
```
- `ticks` — интервал выполнения задачи по обновлению черного экрана в игровых тиках (1 секунда = 20 тиков).

## Команды и права доступа
### `/blackscreen <ник читера>`
Переключает состояние черного экрана для указанного игрока.

**Права:**
- `cfblackscreen.use` — позволяет использовать команду `/blackscreen`.

## Фотографии
**1.16.5**
![image](https://github.com/user-attachments/assets/e763d366-96e3-40cd-b131-c92e9e178c8e)
**1.20+**
https://imgur.com/a/Y89IOec
