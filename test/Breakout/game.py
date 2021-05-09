import sys
import pygame

from constants import *
from paddle import Paddle
from ball import Ball
from brick import Brick

class Breakout:
    def __init__(self):
        self.init_pygame()
        self.screen = pygame.display.set_mode(SCREEN_SIZE)
        self.clock = pygame.time.Clock()
        self.all_sprites_list = pygame.sprite.Group()

        self.score = 0
        self.lives = 3
        self.level = 1
        self.running = True

        self.init_paddle()
        self.init_ball()
        self.init_bricks()

    def init_pygame(self):
        pygame.init()
        pygame.display.set_caption(SCREEN_TITLE)
        
    def init_paddle(self):
        self.paddle = Paddle(COLOR_LIGHTBLUE, PADDLE_LENGTH, PADDLE_HEIGHT)
        self.paddle.rect.center = PADDLE_POS

        self.all_sprites_list.add(self.paddle)
        
    def init_ball(self):
        self.ball = Ball(COLOR_WHITE, 10)
        self.ball.rect.center = BALL_POS

        self.all_sprites_list.add(self.ball)

    def init_bricks(self):
        self.all_bricks = pygame.sprite.Group()
        for i in range(1, NUM_BRICK_ROWS+1):
            for j in range(NUM_BRICK_COLS):
                brick = Brick(BRICK_WIDTH, BRICK_HEIGHT, NUM_BRICK_ROWS+1 - i)
                brick.rect.left = BRICK_OFFSET_LEFT + j*70
                brick.rect.top = BRICK_OFFSET_TOP + i*30
                self.all_sprites_list.add(brick)
                self.all_bricks.add(brick)

    def main_loop(self):
        while self.running:
            self.handle_input() #keys
            self.game_logic()
            self.draw()

            self.clock.tick(60)

    def handle_input(self):
        keys = pygame.key.get_pressed()
        for event in pygame.event.get():
            if event.type == pygame.QUIT: 
                sys.exit()
        
        self.paddle_movement(keys)

    def paddle_movement(self, keys):
        if keys[pygame.K_LEFT]:
            self.paddle.moveLeft()
        if keys[pygame.K_RIGHT]:
            self.paddle.moveRight()

    def game_logic(self):
        self.check_wall_collision()
        self.check_paddle_collision()
        self.check_brick_collision()
        self.check_level_done()
        self.all_sprites_list.update()
    
    def check_level_done(self):
        if len(self.all_bricks) == 0:
            self.level += 1
            font = pygame.font.Font(None, 74)
            text = font.render("LEVEL COMPLETE", 1, COLOR_WHITE)
            text_rect = text.get_rect(center=(WIDTH / 2, HEIGHT / 2))
            self.screen.blit(text, text_rect)

            pygame.display.flip()
            pygame.time.wait(3000)

            self.ball.rect.center = (WIDTH / 2, HEIGHT - 50)
            self.ball.velocity[1] = -abs(self.ball.velocity[1])
            self.init_bricks()

    def check_wall_collision(self):
        if self.ball.rect.left <= 0 or self.ball.rect.right >= WIDTH:
            self.ball.velocity[0] = -self.ball.velocity[0]
        if self.ball.rect.top <= 0:
            self.ball.velocity[1] = -self.ball.velocity[1]
        if self.ball.rect.bottom >= HEIGHT:
            self.ball.velocity[1] = -self.ball.velocity[1]
            self.lives -= 1
            if self.lives == 0:
                font = pygame.font.Font(None, 74)
                gameoverText = font.render("GAME OVER", 1, COLOR_WHITE)
                gameoverText_rect = gameoverText.get_rect(center=(WIDTH/2, HEIGHT/2))
                self.screen.blit(gameoverText, gameoverText_rect)
                pygame.display.flip()
                pygame.time.wait(3000)
                self.running = False

    def check_paddle_collision(self):
        if pygame.sprite.collide_mask(self.ball, self.paddle):
            self.ball.bounce()

    def check_brick_collision(self):
        brick_collision_list = pygame.sprite.spritecollide(self.ball, self.all_bricks, False)
        for brick in brick_collision_list:
            self.ball.bounce()
            self.score += 1
            
            if(brick.numHits == 1):
                brick.kill()
            else:
                brick.numHits -= 1
                newBrick = Brick(BRICK_WIDTH, BRICK_HEIGHT, brick.numHits)
                newBrick.rect.left = brick.rect.left
                newBrick.rect.top = brick.rect.top
                self.all_sprites_list.add(newBrick)
                self.all_bricks.add(newBrick)

                brick.kill()

    def draw(self):
        self.screen.fill(COLOR_BLACK)
        self.draw_scoreboard()
        self.all_sprites_list.draw(self.screen)
        pygame.display.flip()

    def draw_scoreboard(self):
        font = pygame.font.Font(None, 40)

        scoreText = font.render("Score: " + str(self.score), 1, COLOR_WHITE)
        scoreText_rect = scoreText.get_rect(left = 0, top = 0)
        self.screen.blit(scoreText, scoreText_rect)

        levelText = font.render("Level: " + str(self.level), 1, COLOR_WHITE)
        levelText_rect = levelText.get_rect(centerx=WIDTH/2, top = 0)
        self.screen.blit(levelText, levelText_rect)

        livesText = font.render("Lives: " + str(self.lives), 1, COLOR_WHITE)
        livesText_rect = livesText.get_rect(right = WIDTH, top = 0)
        self.screen.blit(livesText, livesText_rect)

def main():
    breakout = Breakout()
    breakout.main_loop()

if __name__ == "__main__":
    main()
