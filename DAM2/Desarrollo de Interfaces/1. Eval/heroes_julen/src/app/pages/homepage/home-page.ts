import {
  Component
} from '@angular/core';
import {
  CommonModule
} from '@angular/common';
import {
  Router,
  RouterModule
} from '@angular/router';
import {
  Hero
} from '../../hero/hero';
import {
  allHeroes
} from '../../hero/hero';

@Component({
  selector: 'app-home-page',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './home-page.html',
  styleUrl: './home-page.css',
})
export class HomePage {
  topHeroes: Hero[] = allHeroes.slice(0, 4);

  constructor(private router: Router) {}

  goToHeroesPage() {
    this.router.navigate(['/heroes']);
  }
}
